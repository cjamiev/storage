package com.cjv.storage.services;

import com.cjv.storage.models.Location;
import com.cjv.storage.repository.LocationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> getAllLocations() {
        String sql = "SELECT * FROM public.location";

        Optional<List<Location>> retrievedLocations = Optional.of(jdbcTemplate.query(sql, new LocationRowMapper()));
        List<Location> emptyList = new ArrayList<>();
        emptyList.add(Location.getEmptyLocation());

        return retrievedLocations.orElse(emptyList);
    }

    public int addNewLocation(Location location) {
        String sql = "INSERT INTO public.location(code, state, cities) VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                location.getCode(),
                location.getState(),
                location.getCities()
        );
    }

    public int updateLocation(Location location) {
        String sql = "UPDATE public.location SET state=?, cities=? WHERE code = ?;";

        return jdbcTemplate.update(
                sql,
                location.getState(),
                location.getCities(),
                location.getCode()
        );
    }

    public int deleteLocation(String code) {
        String sql = "DELETE FROM public.location WHERE code = ?";

        return jdbcTemplate.update(
                sql,
                code
        );
    }
}
