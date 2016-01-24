package com.springapp.mvc.service;

import com.springapp.mvc.entity.Game;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 25.1.16.
 */
@Service("gameServiceImpl")
public class GameServiceImpl extends BaseServiceImpl<Game, Integer> implements GameService {
}
