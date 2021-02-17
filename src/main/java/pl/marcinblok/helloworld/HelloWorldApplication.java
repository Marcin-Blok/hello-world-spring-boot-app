package pl.marcinblok.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World!")String name){
		return String.format("Hello %s!", name);
	}
}


/*
	Metoda hello() przyjmuje String jako parametr i łączy go ze słowem Hello w kodzie.
	Podanie imienia w żądaniu, spowoduje wyświetlenie ciągu znaków: Hello + imię.
	Adnotacja @RestController, mówi Springowi, że kod opisuje end-point aplikacji który ma być dostępny , poprzez sieć.
	Adnotacja @GetMapping(“/hello”), mówi Springowi, aby użyć tej metody by zwrócić odpowiedź na żądanie
	wysłane pod adres http://localhost:8080/hello.
	Adnotacja @RequestParam, mówi Springowi że może oczekiwać wartości "name" w żądaniu, ale jeśli
	tak się nie stanie to ma użyć słowa World jako wartości default-owej.
	Przykład użycia:
	localhost:8080/hello?name=Marcin
	W odpowiedzi na powyższe żądanie, otrzymuję:
	Witaj Marcin!
 */