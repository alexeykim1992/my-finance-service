package my.projects.myfinance.service;

import my.projects.myfinance.model.Icon;
import my.projects.myfinance.repo.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconService {

    @Autowired
    IconRepo iconRepo;

    public List<Icon> getIcons(){
        return iconRepo.findAll();
    }
}
