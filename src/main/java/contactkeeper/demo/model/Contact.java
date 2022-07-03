package contactkeeper.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Contact  {
    @Id
    private String id = UUID.randomUUID().toString().toUpperCase();

    @NotNull(message = "Username is required")
    private String name;

    @NotNull(message = "Phone Number is required")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private MyUser myUser;
}
