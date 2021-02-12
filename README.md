# 2iBi
Projecto de teste técnico para adesão á vaga de Developer na 2iBi

O projecto foi desenvolvido usando a linguagem JAVA, acompanhado com o Framework Spring Boot, JPA (conexão com database) e Hibernate

Os testes serão possíveis usando as mais vulgares ferramentas de testes como POSTMAN

O projecto supriu todos requisitos solicitados, desde já apresento a descrição dos ENDPOINTS para facitar os testes:
  - Deve ser possível criar um novo país a partir da API criada com todas as suas propriedades.
  
<i> POST </i> : api/paises

  - Deve ser possível listar todos os países anteriormente criados;
  
 <i> GET </i> : api/paises
  
  - Deve ser possível modificar os dados de um país anteriormente criado;
  
 <i> PUT </i> : api/paises/{id}
 
  - Deve ser possível eliminar um país anteriormente criado;
  
 <i> DELETE </i> : api/paises/{id}  ou até mesmo apagar todos de uma e única vez :  <i> DELETE </i> : api/paises
 
  - Deve ser possível ordenar a lista dos países por qualquer uma das suas propriedades.
  
 <i> GET </i> : api/paisesss/{atributo}
    
  
