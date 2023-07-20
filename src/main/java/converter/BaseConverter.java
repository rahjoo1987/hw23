package converter;

import base.domain.BaseEntity;
import command.BaseCommand;

public interface BaseConverter <C extends BaseCommand, T extends BaseEntity>{
    T convert (C c);
}
