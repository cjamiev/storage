package com.cjv.storage.services;

import com.cjv.storage.models.City;
import com.cjv.storage.repository.CityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> getAllCities() {
        String sql = "SELECT * FROM public.city";

        Optional<List<City>> retrievedCities = Optional.of(jdbcTemplate.query(sql, new CityRowMapper()));
        List<City> emptyList = new ArrayList<>();
        emptyList.add(City.getEmptyCity());

        return retrievedCities.orElse(emptyList);
    }

    public int addNewCity(City city) {
        String sql = "INSERT INTO public.city(id, origin) VALUES (?, ?)";

        return jdbcTemplate.update(
                sql,
                city.getId(),
                city.getOrigin()
        );
    }

    public int updateCity(City city) {
        String sql = "UPDATE public.city SET origin=? WHERE id = ?;";

        return jdbcTemplate.update(
                sql,
                city.getOrigin(),
                city.getId()
        );
    }

    public int deleteCity(String id) {
        String sql = "DELETE FROM public.city WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}
