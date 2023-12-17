package TravelAgency.services;

import TravelAgency.repositories.TourRepository;
import TravelAgency.entities.Tours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private TourRepository tourRepository;

    @Autowired
    public void setTourRepository(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tours> getAllProducts() {
        return tourRepository.findAll();
    }

    public Tours getProductById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public Tours getProductByTitle(String title) {
        return tourRepository.findOneByTitle(title);
    }

    public void saveProduct(Tours tour) {
        tourRepository.save(tour);
    }

    public void updateProduct(Tours tour) {
        if (tourRepository.existsById(tour.getId())) {
            tourRepository.save(tour);
        } else {
            // Handle the case where the tour with the given ID doesn't exist
            throw new RuntimeException("Tour not found");
        }
    }

    public void deleteProductById(Long id) {
        tourRepository.deleteById(id);
    }
    public void saveTour(Tours tour) {
        tourRepository.save(tour);
    }

    public void updateTour(Tours tour) {
        if (tourRepository.existsById(tour.getId())) {
            tourRepository.save(tour);
        } else {
            // Handle the case where the tour with the given ID doesn't exist
            throw new RuntimeException("Tour not found");
        }
    }

}
