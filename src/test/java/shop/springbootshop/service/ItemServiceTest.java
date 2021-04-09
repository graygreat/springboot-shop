package shop.springbootshop.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import shop.springbootshop.domain.Item.Book;
import shop.springbootshop.domain.Item.Item;
import shop.springbootshop.domain.Item.ItemRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void 아이템_저장_후_확인() throws Exception {
        //given
        Item book = new Book();
        book.setName("객체지향의 사실과 오해");

        //when
        Long savedItem = itemService.saveItem(book);

        //then
        assertThat(book).isEqualTo(itemRepository.findOne(savedItem));
    }
}