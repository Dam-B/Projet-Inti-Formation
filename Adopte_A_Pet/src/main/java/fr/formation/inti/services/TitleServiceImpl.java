package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.ITitleService;
import fr.formation.inti.Iservices.Title;
import fr.formation.inti.dao.ITitleRepository;
@Service
public class TitleServiceImpl implements ITitleService {
	@Autowired
	private ITitleRepository titleRepository;

	@Override
	public void save(Title title) {
		titleRepository.save(title);
		
	}

	@Override
	public void update(Title title) {
		String newTitleName = title.getTitle();;
		Title tl2 = titleRepository.findByIdtitle(title);
		tl2.setTitle(newTitleName);
		
		
	}

	@Override
	public void delete(Title title) {
		Title tl2 = titleRepository.findByIdtitle(title);
		titleRepository.delete(title);
		
	}

	@Override
	public Title findByIdtitle(String title) {
		ITitleService title2 = titleRepository.findByIdtitle(title);		
		return title2.getTitle();
	}
	
	

}
