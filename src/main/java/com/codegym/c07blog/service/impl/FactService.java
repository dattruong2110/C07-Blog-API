package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.dto.FactDTO;
import com.codegym.c07blog.entity.Fact.Fact;
import com.codegym.c07blog.entity.Fact.FactUser;
import com.codegym.c07blog.entity.Picture;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;
import com.codegym.c07blog.payload.request.FactRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.payload.response.UserResponse;
import com.codegym.c07blog.repository.IFactUserRepository;
import com.codegym.c07blog.repository.IFactRepository;
import com.codegym.c07blog.repository.IPictureRepository;
import com.codegym.c07blog.repository.IUserRepository;
import com.codegym.c07blog.service.IFactService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FactService implements IFactService {
    private final IFactRepository factRepository;
    private final IUserRepository userRepository;
    private final IFactUserRepository factUserRepository;
    private final IPictureRepository pictureRepository;

    public FactDTO getFactWithUserById(UUID factId) {
        Optional<Fact> fact = factRepository.findById(factId);

        if(fact.isPresent()) {
            return mapToFactDTO(fact.get());
        }
        return null;
    }

    public List<FactDTO> getAllFacts() {
        List<Fact> facts = factRepository.findAll();
        return facts.stream()
                .map(this::mapToFactDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FactDTO mapToFactDTO(Fact fact) {
        FactDTO factDTO = new FactDTO();
        factDTO.setId(fact.getId());
        factDTO.setPicture(fact.getPicture());
        factDTO.setContent(fact.getContent());
        factDTO.setLikes(fact.getLikes());
        factDTO.setComment(fact.getComment());

        FactUser factUser = fact.getFactUser();
        if (factUser != null) {
            UserRole userRole = factUser.getUserRole();
            if (userRole != null) {
                User user = userRole.getUser();

                if (user != null) {

                    UserResponse userResponse = new UserResponse();
                    userResponse.setId(user.getId());
                    userResponse.setFullName(user.getFullName());
                    userResponse.setUsername(user.getUsername());
                    userResponse.setEmail(user.getEmail());
                    userResponse.setAvatar(user.getAvatar());

                    userResponse.setRoles(user.getUserRole().stream()
                            .map(ur -> ur.getRole().getName())
                            .collect(Collectors.toSet()));
                    factDTO.setUser(userResponse);
                }
            }
        }
        return factDTO;
    };

    @Override
    @Transactional
    public ResponsePayload createFactAndFactUser(FactRequest factRequest) {
        Optional<User> user = userRepository.findById(factRequest.getUserId());

        FactUser factUser = new FactUser();
        Fact fact = new Fact();
        Picture picture = new Picture();

        UserRole userRole = user.get().getUserRole().stream().findFirst().orElse(null);

        fact.setFactUser(factUser);
        factUser.setFact(fact);

        factUser.setUserRole(userRole);
        factUserRepository.save(factUser);

        picture.setUrl(factRequest.getPicture());
        picture.setDescription("Fact picture");
        pictureRepository.save(picture);

        fact.setPicture(picture);

        fact.setContent(factRequest.getContent());
        fact.setLikes(factRequest.getLikes());
        fact.setComment(factRequest.getComment());

        factRepository.save(fact);

        return ResponsePayload.builder()
                .message("Fact created successfully")
                .build();
    }

    @Override
    public Fact findById(UUID id) {return factRepository.findById(id).orElse(null);}

    @Override
    public List<Fact> findAll() {return factRepository.findAll();}

    @Override
    public void save(Fact fact) {factRepository.save(fact);}

    @Override
    public void deleteById(UUID id) {factRepository.deleteById(id);}

    @Override
    public List<Fact> findByContent(String content) {
        return factRepository.findAllByContentContaining((content));
    }
}
