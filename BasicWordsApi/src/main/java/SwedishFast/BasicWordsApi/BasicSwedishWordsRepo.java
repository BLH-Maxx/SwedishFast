package SwedishFast.BasicWordsApi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicSwedishWordsRepo extends JpaRepository<Basicwords,String> {
	
	public List<Basicwords> findAllByOrderByNumberoftimesDesc();
	
}
