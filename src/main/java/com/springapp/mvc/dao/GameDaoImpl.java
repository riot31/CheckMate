package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Game;
import org.springframework.stereotype.Repository;

/**
 * Created by o.lutsevich on 25.1.16.
 */
@Repository("gameDaoImpl")
public class GameDaoImpl extends BaseDaoImpl<Game, Integer> implements GameDao {
}
