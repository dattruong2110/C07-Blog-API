package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.dto.BlogDTO;
import com.codegym.c07blog.entity.Blog.Blog;
import com.codegym.c07blog.entity.Blog.BlogUser;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;
import com.codegym.c07blog.payload.response.UserResponse;
import com.codegym.c07blog.repository.IBlogRepository;
import com.codegym.c07blog.service.IBlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogService implements IBlogService {

    private  final IBlogRepository blogRepository;

    public BlogDTO getBlogWithUserById(UUID blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);

        if (blog.isPresent()) {
            return mapToBlogDTO(blog.get());
        }

        return null;
    }

    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(this::mapToBlogDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BlogDTO mapToBlogDTO(Blog blog) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blog.getId());

        BlogUser blogUser = blog.getBlogUser();
        if (blogUser != null) {
            UserRole userRole = blogUser.getUserRole();
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
                    blogDTO.setUser(userResponse);
                }
            }
        }
        return blogDTO;
    };



    @Override
    public Blog findById(UUID id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(UUID id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return blogRepository.findByTitleContainingIgnoreCase((title));
    }

}
