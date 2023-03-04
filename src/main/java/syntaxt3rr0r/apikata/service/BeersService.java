package syntaxt3rr0r.apikata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syntaxt3rr0r.apikata.dto.CreateBeersDTO;
import syntaxt3rr0r.apikata.modelo.Beers;
import syntaxt3rr0r.apikata.modelo.Categories;
import syntaxt3rr0r.apikata.modelo.Styles;
import syntaxt3rr0r.apikata.repo.BeersRepo;
import syntaxt3rr0r.apikata.repo.CategoriesRepo;
import syntaxt3rr0r.apikata.repo.StylesRepo;
import syntaxt3rr0r.apikata.service.base.BaseService;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BeersService extends BaseService<Beers, Long, BeersRepo> {

    private final CategoriesRepo categoriesRepo;
    private final StylesRepo stylesRepo;

    public Beers newBeers ( CreateBeersDTO newBeerData ){

        Beers beers = new Beers();
        Categories categories = categoriesRepo.findById(newBeerData.getId_Category()).orElse(null);
        Styles styles = stylesRepo.findById(newBeerData.getId_Category()).orElse(null);
        Date now = new Date();

        beers.setName(newBeerData.getName());
        beers.setCategories(categories);
        beers.setStyle(styles);
        beers.setAbv(newBeerData.getAbv());
        beers.setIbu(newBeerData.getIbu());
        beers.setSrm(newBeerData.getSrm());
        beers.setUpc(newBeerData.getUpc());
        beers.setFilepath(newBeerData.getFilepath());
        beers.setDescript(newBeerData.getDescript());
        beers.setAdd_user(newBeerData.getAdd_user());
        beers.setLast_mod(now);

        return save(beers);
    }

}
