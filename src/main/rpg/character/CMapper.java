package main.rpg.character;

import org.apache.ibatis.annotations.*;

public interface CMapper {
    @Select("SELECT * from characterinfo")
    Character getCharacterData() throws Exception;

}
