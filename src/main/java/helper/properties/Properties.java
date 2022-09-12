package helper.properties;

import org.aeonbits.owner.ConfigFactory;

/**
 * @author Администратор
 * @date 26.08.2022
 */

public class Properties {
    /**
     * автор Сергей Костенко
     * поле для хранения значение url адреса считанного из properties файла
     */
    public static final UrlProperties urlProperties = ConfigFactory.create(UrlProperties.class);
}
