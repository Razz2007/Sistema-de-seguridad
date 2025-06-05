package com.taller.Sistema_Seguridad.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    // Relación: Un rol puede estar asociado a muchos usuarios.
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<user> users;

    // Relación: Un rol puede tener varios permisos asociados a través de la entidad PermissionRole.
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<PermissionRole> permissionRoles;

}