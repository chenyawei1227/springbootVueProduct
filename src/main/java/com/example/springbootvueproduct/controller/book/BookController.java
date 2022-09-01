package com.example.springbootvueproduct.controller.book;

import com.example.springbootvueproduct.vo.BookVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: Luck
 * @Date: 2022/8/16
 */
@Controller
@RequestMapping("/book")
public class BookController {

  @GetMapping("/list")
  public ModelAndView books(){
    List<BookVO> list = new ArrayList<>();
    BookVO bookVO = new BookVO();
    bookVO.setId("1");
    bookVO.setName("《百年孤独》");
    bookVO.setAuthor("哥伦比亚作家加西亚·马尔克斯");
    BookVO bookVO2 = new BookVO();
    bookVO2.setId("2");
    bookVO2.setName("《蛙》");
    bookVO2.setAuthor("莫言");
    list.add(bookVO);
    list.add(bookVO2);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("books",list);
    modelAndView.setViewName("books");
    return modelAndView;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public BookVO getBookById(@PathVariable("id") String id){
    BookVO bookVO = new BookVO();
    bookVO.setId(id);
    bookVO.setName("《百年孤独》");
    bookVO.setAuthor("哥伦比亚作家加西亚·马尔克斯");
    return bookVO;
  }

  @PostMapping("/add")
  @CrossOrigin(value = "http://localhost:8081", maxAge = 1800 , allowedHeaders = "*")
  @ResponseBody
  public String addBook(@RequestBody BookVO bookVO){
    return bookVO.getName();
  }

}
