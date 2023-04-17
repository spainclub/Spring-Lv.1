package com.sparta.project.Controller;

import com.sparta.project.Dto.PostRequestDto;
import com.sparta.project.Dto.PostResponseDto;
import com.sparta.project.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    //전체 게시글 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> getPosts() {
        List<PostResponseDto> postResponseDto = postService.getPosts();
        return postResponseDto;
    }
    
    //게시글 작성
    @PostMapping("/api/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    //선택한 게시글 조회
    @GetMapping("/api/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    //게시글 수정
    @PutMapping("/api/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.deletePost(id, requestDto);
    }


}
