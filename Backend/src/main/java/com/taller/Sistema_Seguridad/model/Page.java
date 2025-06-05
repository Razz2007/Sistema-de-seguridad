package com.taller.Sistema_Seguridad.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "pages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name = "name", length = 50, nullable = false)
   private String name;
   @Column(name = "url", length = 100, nullable = false)
   private String url;

   // Relación many-to-many con roles
   @ManyToMany
   @JoinTable(name = "page_roles",
              joinColumns = @JoinColumn(name = "page_id"),
              inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<role> roles;

   // Relación one-to-many con PermissionRole
   @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
   private Set<PermissionRole> permissionRoles;
}
