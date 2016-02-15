package com.springapp.mvc.service.converter;

import com.springapp.mvc.entity.Game;
import com.springapp.mvc.service.form.GameForm;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 7.2.16.
 */
@Service("gameConverter")
public class GameConverter extends AbstractConverter<Game, GameForm> {
}
