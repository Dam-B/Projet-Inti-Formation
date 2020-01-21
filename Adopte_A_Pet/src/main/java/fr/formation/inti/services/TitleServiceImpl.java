package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.ITitleService;
import fr.formation.inti.dao.ITitleRepository;
import fr.formation.inti.entities.Title;
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
		String newTitleName = title.getTitle();
		Title tl2 = titleRepository.findByIdtitle(title.getIdtitle());
		tl2.setTitle(newTitleName);
		
		
	}

	@Override
	public void delete(Integer idtitle) {
		Title tl2 = titleRepository.findByIdtitle(idtitle);
		titleRepository.delete(tl2);
		
	}

	@Override
	public Title findByIdtitle(Integer idtitle) {		
		return titleRepository.findByIdtitle(idtitle);
	}
	
	

}
