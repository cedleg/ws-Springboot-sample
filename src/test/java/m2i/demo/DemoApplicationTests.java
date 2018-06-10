package m2i.demo;

import m2i.demo.model.Personne;
import m2i.demo.repository.PersonneRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles({"TEST"})
public class DemoApplicationTests {

	private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private PersonneRepository repository;

	@Before
    public void before(){
	    repository.deleteAll();
    }

	@Test
	public void contextLoads() {
	}

	@Test
    public void testBonjour(){
	    String response = restTemplate.getForObject("http://localhost:9001/hello", String.class);
        Assert.hasText("Bonjour", response);
    }

    @Test
    public void testStatusBonjour(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9001/hello", String.class);
        Assert.isTrue(response.getStatusCodeValue()==200, "error service code non OK");
    }

    @Test
    public void testPostPersonne(){
        Personne p = new Personne();
        p.setPrenom("TestPrenom");
        p.setNom("TestNom");
        p.setAge(10);

        ResponseEntity<Personne> response = restTemplate.postForEntity("http://localhost:9001/add3", p, Personne.class);
        Assert.isTrue(response.getStatusCodeValue()==200, "error service code non OK");
        Personne maResponse = response.getBody();
        Assert.isTrue(maResponse!=null, "Object Personne return null");
        Assert.isTrue(maResponse.getPrenom().equals("TestPrenom"), "Erreur de prénom");
        Assert.isTrue(maResponse.getNom().equals("TestNom"), "Erreur de nom");
        Assert.isTrue(maResponse.getAge()==10, "Erreur sur l'age");
    }

    @After
    public void after(){
        repository.deleteAll();
    }

}
