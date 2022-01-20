package com.nttdata.bootcamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ObserverAppApplication {
//micro reactiva con observers y observables, flux y mono
	public static void main(String[] args) {
		SpringApplication.run(ObserverAppApplication.class, args);
		
//		Flux<String> messageSender = Flux.just("Mensaje 1", "Mensaje 2", "Mensaje 3");
//				
//		messageSender.subscribe(message -> System.out.println("Consumer 1. Received: " + message),
//				e -> System.out.println("Consumer 1. Error: " + e.getMessage()),
//				() -> System.out.println("Consumer 1. Completed"));
//		
//		messageSender.subscribe(message -> System.out.println("Consumer 2. Received: " + message),
//				e -> System.out.println("Consumer 2. Error: " + e.getMessage()),
//				() -> System.out.println("Consumer 2. Completed"));
//		
//		messageSender.doOnNext((element) -> {
//			System.out.println(element);
//		}).blockFirst();
		
    	Observable<String> messageSender = Observable.just("Mensaje 1", "Mensaje 2", "Mensaje 3");
	    
		messageSender.subscribe(new Observer<String>() {
	        @Override
	        public void onSubscribe(Disposable d) {
	            System.out.println("Observer 1. Subscribed.");
	        }

	        @Override
	        public void onNext(String s) {
	            System.out.println("Observer 1. Received: " + s);
	        }

	        @Override
	        public void onError(Throwable e) {
	            System.out.println("Observer 1. Error: " + e.getMessage());
	        }

	        @Override
	        public void onComplete() {
	            System.out.println("Observer 1. Completed");
	        }
	    });
		
		messageSender.subscribe(new Observer<String>() {
	        @Override
	        public void onSubscribe(Disposable d) {
	            System.out.println("Observer 2. Subscribed.");
	        }

	        @Override
	        public void onNext(String s) {
	            System.out.println("Observer 2. Received: " + s);
	        }

	        @Override
	        public void onError(Throwable e) {
	            System.out.println("Observer 2. Error: " + e.getMessage());
	        }

	        @Override
	        public void onComplete() {
	            System.out.println("Observer 2. Completed");
	        }
	    });
	}
}
