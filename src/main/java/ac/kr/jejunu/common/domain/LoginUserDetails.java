package ac.kr.jejunu.common.domain;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Boobby on 17-5-15.
 */
public class LoginUserDetails extends User {
    private static final long serialVersionUID = 1L;

    @Getter
    private ac.kr.jejunu.common.entity.User user;

    public LoginUserDetails(ac.kr.jejunu.common.entity.User user) {
        super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));

        this.user = user;
    }
}
