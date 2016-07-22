package com.springapp.mvc.boot;

import com.springapp.mvc.boot.board.Move;
import org.springframework.stereotype.Service;

/**
 * Created by o.lutsevich on 19.7.16.
 */
@Service
public abstract class HeadBoot {
    abstract public Move brain(String gameUuid);

    abstract public String getName();
}
