package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.dto.BlogDTO;
import com.codegym.c07blog.dto.UserDTO;
import com.codegym.c07blog.entity.Blog.Blog;
import com.codegym.c07blog.entity.Blog.BlogUser;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;
import com.codegym.c07blog.repository.IBlogRepository;
import com.codegym.c07blog.service.IBlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BlogService implements IBlogService {

    private  final IBlogRepository blogRepository;


    public BlogDTO getBlogWithUserById(UUID Id) {

        Optional<Blog> blog = blogRepository.findById(Id);

        if (blog.isPresent()) {
            Blog b = blog.get();
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setId(b.getId());

            BlogUser blogUser = b.getBlogUser();
            if (blogUser != null) {
                UserRole userRole = blogUser.getUserRole();
                if (userRole != null) {
                    User user = userRole.getUser();
                    if (user != null) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setId(user.getId());
                        userDTO.setUsername(user.getUsername());
                        blogDTO.setUser(userDTO);
                    }
                }
            }
            return blogDTO;
        }

        return null; // Hoặc ném ra một exception phù hợp
    }

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
