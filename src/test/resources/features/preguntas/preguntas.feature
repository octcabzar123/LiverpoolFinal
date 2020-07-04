Feature: Encontrar preguntas frecuentes

  Scenario Outline: Encontrar formas de pago
    Given Necesito entrar a la página de Ayuda
    And Voy a la sección de <section>
    Then I verify the <status> in step

    Examples: 
      | section |
      | name1   |
      | name2   |
