package mk.ukim.finki.emt.librarybackend.service.impl;

import mk.ukim.finki.emt.librarybackend.model.Country;
import mk.ukim.finki.emt.librarybackend.repository.CountryRepository;
import mk.ukim.finki.emt.librarybackend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

}
