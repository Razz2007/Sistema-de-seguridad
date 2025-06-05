package com.taller.Sistema_Seguridad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "permission_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRole {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name = "permission", length = 50, nullable = false)
   private String permission;

   @ManyToOne
   @JoinColumn(name = "role_id")
   private role role;

   @ManyToOne
   @JoinColumn(name = "page_id")
   private Page page;
}
