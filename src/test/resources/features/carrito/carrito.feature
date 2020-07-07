Feature: Agregar artículo al carrito

  Scenario Outline: Agregar maletas y extractor al carrito
    Given Entro a la página Tienda en línea de Liverpool
    When Busco primer <primero> en la página
    And Busco segundo <segundo> en página de producto
    And Verifico la informacion

    Examples: 
      | primero | segundo   |
      | maletas | extractor |
