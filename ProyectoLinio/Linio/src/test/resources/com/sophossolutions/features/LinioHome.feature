#Author: jonathan.castro@sophossolutions.com
Feature: Agregar productos carrito de compras linio
  Yo deseo automatizar las pruebas de agregar productos al carrito de compras

  Scenario Outline: Title of your scenario outline
    Given Yo deseo buscar mi producto en la pagina de linio
    When busco <producto>
    Then Agrego al carrito el <producto> con más reseñas

    Examples: 
      | producto            |
      | "sillas de oficina-3" |
      | "Televisores-3"       |
