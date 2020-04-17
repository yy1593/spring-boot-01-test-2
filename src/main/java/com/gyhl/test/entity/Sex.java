package com.gyhl.test.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author yang
* @since 2020-03-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Sex implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String sex;


}
