package com.example.currencyconversionservice.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class CurrencyConversionService {
	
	Logger logger = LoggerFactory.getLogger(CurrencyConversionService.class);

    @CircuitBreaker(name = "currency-exchange-service")
    @Retry(name = "currency-exchange-service", fallbackMethod = "cbFallBack")
    public String circuitBreaker(String id) {
    	logger.info("Trying to invoke circuitBreaker for {}",id);
        return cbRemoteCall();
    }
    private String cbRemoteCall() {
        double random = Math.random();
        //should fail more than 70% of time
        if (random <= 1) {
            throw new RuntimeException("CB Remote Call Fails");
        }
            return "CB Remote Call Executed";
    }
    
    public String cbFallBack(Exception ex) {
    	return "cbFallBack Call Executed";
    }
    
    @TimeLimiter(name = "currency-exchange-service", fallbackMethod = "tmlFallback")
    public CompletableFuture<String> timelimitter() {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return CompletableFuture.completedFuture("TimeLimitter executed");
    }
    
    public CompletableFuture tmlFallback(Exception ex) {
    	return CompletableFuture.completedFuture("tmlFallback call executed");
    }
    
    @RateLimiter(name = "currency-exchange-service", fallbackMethod = "rmlFallback")
    public String rateLimitter() {
    	return "Ratelimitter executed.";
    }
    
    public String rmlFallback(Exception ex) {
    	return "Ratelimitter Fallback executed";
    }
}
