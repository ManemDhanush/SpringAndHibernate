package com.librarysystem.service;

import com.librarysystem.exception.NotFoundException;
import com.librarysystem.repository.PublisherRepository;
import com.librarysystem.entity.Publisher;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublisherServiceImpl implements  PublisherService{
    final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(int theId) {
       /* Optional<Publisher> result = publisherRepository.findById(theId);

        Publisher thePublisher = null;

        if (result.isPresent()) {
            thePublisher = result.get();
        }
        else {
            // we didn't find the publisher
            throw new RuntimeException("Did not find publisher id - " + theId);
        }

        return thePublisher;

 */
         return publisherRepository.findById(theId)
                .orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", theId)));
    }


    @Override
    public void save(Publisher thePublisher) {
        publisherRepository.save(thePublisher);
    }

    @Override
    public void deleteById(int theId) {
        publisherRepository.deleteById(theId);
    }
}
