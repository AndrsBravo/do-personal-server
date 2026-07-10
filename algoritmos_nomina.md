# SAAS/Comercialización

## Planes de comercialización

## Principales entidades comerciales

| Entidad Comercial  |
| -----------------  |
| Usuario            |
| Cliente            |
| Empresa            |
| Nomina             |
| Empleados          |
| Tiempo Uso         |

Entidades Comerciales

| Plan de Comercialización | Cant. Usuarios | Cant. Clientes | Cant. Empresas | Empleados | Tiempo uso |
| ------------------------ | -------------- |--------------- | -------------- | ----------| ---------- |
| Plan Demo                | 1 Usuario      | 1 Cliente      | 1 Empresa      | 5         | 30 Dias    |
| Plan Consultor           | 2 Usuario      | 2 Cliente      | 5 Empresa      | 100       | Ilimitado  |
| Plan Consultor Pro       | 10 Usuario     | 10 Cliente     | 25 Empresa     | 500       | Ilimitado  |
| Plan Consultor Plus      | 20 Usuario     | 18 Cliente     | 55 Empresa     | 1500      | Ilimitado  |
| Plan Consultor Max       | 30 Usuario     | 25 Cliente     | 75 Empresa     | 2000      | Ilimitado  |
| Plan Micro               | 2 Usuario      | 1 Cliente      | 1 Empresa      | 25        | Ilimitado  |
| Plan Business            | 15 Usuario     | 5 Cliente      | 5 Empresa      | 500       | Ilimitado  |
| Plan Corporate           | 25 Usuario     | 10 Cliente     | 10 Empresa     | 2500      | Ilimitado  |
| Plan Holding             | 50 Usuario     | 20 Cliente     | 20 Empresa     | 5500      | Ilimitado  |

## Aplicación

## Entidades

| Entidad            | Descripción                                                                       | Valores                                      |
| ------------------ | --------------------------------------------------------------------------------- |--------------------------------------------- |
| Usuario            | Mantiene el contenido de la aplicación                                            | Publico,Privados                             |
| - Tipo Usuario     | Auto creados con perfil de cliente, sin perfil de cliente, creados por un cliente | publico cliente, publico no cliente, privado |
| - Roles Usuario    | Roles propios, roles compartidos                                                  | sys-admin,admin,collaborator                 |
| Cliente            | Responsable comercial de los servicios que presta la aplicación                   |                                              |
| - Tipo Cliente     | Clientes mono empresa y multi empresas                                            | particular, grupo, gestores fiscales         |
| Empresas           | Perfil que gestiona y calcula nominas                                             |                                              |

## Estructura de la aplicación

| Nombre de las Entidades     | Nivel |
| --------------------------- | ----- |
| Usuario                     | 1     |
| Cliente                     | 2     |
| Empresa                     | 3     |
| - Estructura Organizacional | 3     |
| - Estructura Jerárquica     | 3     |
| - Organizacional            | 3     |
| - Jerárquica/Escalas        | 3     |
| Empleado                    | 4     |
| - Cargo/Rol                 | 4     |
| - Beneficios/Ingresos       | 4     |
| Nomina                      | 4     |
| - Calculo de la Nomina      | 4     |
| - Ingresos                  | 5     |
| - Compensaciones            | 5     |
| - Beneficios                | 5     |
| - Bonos                     | 5     |
| - Derecho adquirido         | 5     |
| - Deducciones               | 5     |
| - Retenciones               | 5     |
| - Gastos                    | 5     |

## Estructura de la data

### Usuarios

Los Usuarios Mantiene el contenido de la aplicación.

### Tipo Usuarios

| Tipo Usuario       | Descripción                                                      |
| ------------------ | ---------------------------------------------------------------- |
| Master             | Usuario por defecto                                              |
| System             | Usuarios administradores del sistema                             |
| Publico            | Auto creados y puede crear clientes, empresas y otras entidades  |
| Limitado           | Auto creados Sin perfil de cliente, creados por un cliente       |
| Owned              | Creados por un otro usuario para asignar entidades.              |

### Relación Usuarios

Los usuarios se relacionan con las entidades, creándolas o compartiéndolas.

| Relación Usuario   | Descripción                                   |
| ------------------ | --------------------------------------------- |
| Owner              | La entidad fue creada por el usuario.         |
| Shared             | La entidad fue compartida al usuario.         |

### Role Usuarios

| Role Usuario       | Descripción                                                      |
| ------------------ | ---------------------------------------------------------------- |
| master             | Para crear las primeras entidades por defecto                    |
| sys-master         | Para crear las entidades y usuarios administradores de sistemas  |
| sys-admin          | Para administrar entidades y procesos de sistemas                |
| sys-user           | Para gestionar soportes de sistemas                              |
| admin              | Para administrar operaciones de clientes.                        |
| collaborator       | Para gestionar procesos de clientes                              |

## Negocio / Business

## Información Fiscal/Legal

| Tipo de información       |
| ------------------------  |
| Información fiscal        |
| Información Laboral       |
| Información Salud         |
| Información Previsional   |

## Estructura organizacional

| Nombre de la estructura    | Estructura   | Nivel |
| -------------------------- | ------------ | ----- |
| Junta de Accionistas       | Junta        | 1     |
| Junta Directiva            | Junta        | 2     |
| Dirección Ejecutiva        | Dirección    | 3     |
| Dirección General/Regional | Dirección    | 4     |
| Dirección Capitulo         | Dirección    | 5     |
| Gerencia General           | Gerencia     | 6     |
| Gerencia Area              | Gerencia     | 7     |
| Departamentos              | Departamento | 8     |
| Sección/Area               | Sección      | 9     |
| sub-Sección/Sub-Area       | Sub-sección  | 10    |

## Estructura Jerárquica hierarchy

| Nombre de la jerarquía    | Jerarquía    | Nivel |
| ------------------------- | ------------ | ----- |
| Miembro de la Junta Acc   | Miembro      | 1     |
| Miembro de la Junta Dir   | Miembro      | 2     |
| Director Ejecutivo/a      | Director     | 3     |
| Director General/Regional | Director     | 4     |
| Director Capitulo         | Director     | 5     |
| Gerente General           | Gerente      | 6     |
| Gerente de Area           | Gerente      | 7     |
| Jefe de Departamentos     | Jefe         | 8     |
| Coordinador de area       | Coordinador  | 9     |
| Supervisor de area        | Supervisor   | 10    |
| Analista de area          | Analista     | 11    |
| Asistente de area         | Asistente    | 12    |
| Auxiliar de area          | Auxiliar     | 13    |

## Ubicaciones

| Ubicación       | Dirección    | Latitud | Longitud |
| --------------- | ------------ | ------- |--------- |
| Sede principal  | Dirección    | 1       |1         |

## Compensaciones y Beneficios

### Tipo de beneficio financiero

| Tipo de beneficio       | Tipo   | Descripción                                                                                   |
| ----------------------- | ------ | --------------------------------------------------------------------------------------------- |
| Beneficio Monetario     | MO     | Es un beneficio económico que entrega en efectivo al colaborador. Se calcula en la nomina     |
| Beneficio No-Monetario  | NMO    | Es un beneficio económico que entrega en especie al colaborador                               |

### Tipo de beneficio Legal

| Tipo de beneficio       | Tipo     | Descripción                                                            |
| ----------------------- | -------- | ---------------------------------------------------------------------- |
| Beneficio Legal.        | ley      | Es un beneficio económico establecido por ley.                         |
| Beneficio Propio.       | propio   | Es un beneficio económico o no económico establecido por el empleador. |

### Categoría de Beneficios

| Beneficios                    | Legal  | Finanzas  | Descripción                       |
| ----------------------------- |------- | --------  | --------------------------------- |
| Salario Ordinario             | (Ley)  | MO        | Salario principal convenido       |
| Salario Extraordinario        | (Ley)  | MO        | Horas extras pagadas              |
| Salario Especial              | (Ley)  | MO        | Salario de navidad y Vacaciones   |
| Bonificación                  | (Ley)  | MO        | Participación en los beneficios   |
| Compensación de ley           | (Ley)  | MO        | Prestaciones laborales.           |
| Beneficio Ordinario           | propia | MO        | Beneficio empresarial común       |
| Comisión por rendimiento      | propia | MO        | Beneficio empresarial             |
| Bono de cumplimiento          | propia | MO        | Beneficio empresarial             |
| Compensación por contingencia | propia | MO        | Beneficio empresarial             |
| Asignación Ordinaria          | propia | NMO       | Asignación empresarial común      |
| Asignación Especial           | propia | NMO       | Asignación empresarial Especial   |

### Beneficios

| Beneficios                    | Legal  | Finanzas  | Descripción                       |
| ----------------------------- |------- | --------  | --------------------------------- |
| Salario                       | (Ley)  | MO        | Salario principal                 |
| Horas Extraordinarias         | (Ley)  | MO        | Horas extras pagadas              |
| Salario Navidad               | (Ley)  | MO        | Salario numero 13                 |
| Vacaciones Remuneradas        | (Ley)  | MO        | Salario de vacaciones             |
| Bonificación                  | (Ley)  | MO        | Participación en los beneficios   |
| Preaviso                      | (Ley)  | MO        | Cuando no se pre-avisa el despido |
| Cesantía                      | (Ley)  | MO        | Compensación por desahucio        |
| Beneficio Ordinario           | propia | MO        | Beneficio empresarial común       |
| Comisión por rendimiento      | propia | MO        | Beneficio empresarial             |
| Bono de cumplimiento          | propia | MO        | Beneficio empresarial             |
| Compensación por contingencia | propia | MO        | Beneficio empresarial             |
| Asignación Ordinaria          | propia | NMO       | Asignación empresarial común      |
| Asignación Especial           | propia | NMO       | Asignación empresarial Especial   |

### Tipo de Descuento financiero

payroll effect cause.

| Tipo de beneficio       | Tipo     | Descripción                                                                        |
| ----------------------- | -------- | ---------------------------------------------------------------------------------- |
| Retencion.              | RT       | Es un descuento que el empleador debe realizar al trabajador y pagar en su nombre. |
| Descuento.              | DT       | Se realiza al trabajador mediante acuerdo previo.                                  |
| Gasto.                  | GT       | Se calcula en base a la nomina y corresponde el pago completo por el empleador.    |

### Tipo de descuento Legal

| Tipo de beneficio       | Tipo     | Descripción                                                            |
| ----------------------- | -------- | ---------------------------------------------------------------------- |
| Beneficio Legal.        | ley      | Es un beneficio económico establecido por ley.                         |
| Beneficio Propio.       | propio   | Es un beneficio económico o no económico establecido por el empleador. |

### Cargos y Retenciones

| Cargo            |Legal    | tipo  |  Descripción                |
| ---------------- |---------|------ | --------------------------- |
| ISR              |(Ley)    | RT    | Impuesto Sobre Las Rentas   |
| ARS              |(Ley)    | RT    | Seguro de Familiar de Salud |
| AFP              |(Ley)    | RT    | Seguro de Pensiones         |
| INFOTEP          |(Ley)    | RT    | Aporte al INFOTEP           |
| ARS Patronal     |(Ley)    | GT    | Seguro de Familiar de Salud |
| AFP Patronal     |(Ley)    | GT    | Seguro de Pensiones         |
| INFOTEP Patronal |(Ley)    | GT    | Aporte al INFOTEP           |
| Descuento        |propio   | DT    | Descuento comida            |
| Gasto.           |propio   | GT    | Gasto comida                |

### Frecuencias temporales

| Frecuencia       |Titulo   | tipo  |  Descripción                                   |
| ---------------- |---------|------ | ---------------------------------------------- |
| hourly           |Hora     | HL    | Describe una operación calculada cada Hora     |
| daily            |Diario   | DL    | Describe una operación calculada cada dia      |
| weekly           |Semanal  | WL    | Describe una operación calculada cada semana   |
| bi-weekly        |BiSemanal| BW    | Describe una operación calculada cada 2 semana |
| semi-weekly      |Quincenal| SW    | Describe una operación calculada cada 15 días  |
| monthly          |Mensual  | ML    | Describe una operación calculada cada Mes      |
| yearly           |Anual    | YL    | Describe una operación calculada cada Ano      |

### Tipo de liquidación de la nomina

La liquidación es la porción de la nomina que se va a pagar en un periodo dado.

| Liquidación      |Titulo   | tipo     |  Descripción                                   |
| ---------------- |---------|--------- | ---------------------------------------------- |
| partial          |Parcial  | partial  | Se pagara una porción de la nomina.            |
| reminded         |Restante | remind   | Se pagara el remanente de la nomina.           |
| total            |Total    | total    | Se pagara el total de la nomina.               |

#### Tabla

| id     | tipo    | Datos Personales           | Fecha de creación | Fecha de Modificación |
| ------ | ------- | -------------------------- | ----------------- | --------------------- |
| us_001 | publico | Nombre,apellido,contraseña | 27/10/2024        | 27/10/2024            |
| us_100 | privado | Nombre,apellido,contraseña | 27/10/2024        | 27/10/2024            |

### Usuarios - Empresas

| id_usuario | id_empresa | Relación | Role     | Fecha      |
| ---------- | ---------- | -------- | -------- | ---------- |
| us_001     | emp_001    | owner    | admin    | 27/10/2024 |
| us_001     | emp_1001   | shared   | analista | 27/10/2024 |

### Clientes

Es el perfil comercial a quien se facturara los servicios de la plataforma.

| id_usuario | id_perfil | Perfil                                | Fecha creación | Fecha modificación |
| ---------- | --------- | ------------------------------------- | -------------- | ------------------ |
| us_001     | emp_001   | Nombre Comercial, Ubicación,contactos | 27/10/2024     | 27/10/2024         |

### Empresas

Son las entidades a las se le administrara las plantillas y nominas.

| id_usuario | id_empresa | Perfil                                | Fecha creación | Fecha modificación |
| ---------- | ---------- | ------------------------------------- | -------------- | ------------------ |
| us_001     | emp_001    | Nombre Comercial, Ubicación,contactos | 27/10/2024     | 27/10/2024         |

### Empresas - Estructura Organizacional

Es la estructura organizacional de mas alto nivel.

| id_usuario | id_empresa | id_estructura | Estructura          | Descripción          | Cargo            | Fecha creación | Fecha modificación |
| ---------- | ---------- | ------------- | --------------------| -------------------- | ---------------- | -------------- | ------------------ |
| us_001     | emp_001    | est_001       | Dirección General   | Dirección General    | Director General | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_002       | Dirección De Sección| Dirección De Sección | Director         | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_003       | Gerencia de Area    | Gerencia de Area     | Gerente          | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_004       | Departamento        | Departamento         | Jefe             | 27/10/2024     | 27/10/2024         |

### Empresas - Estructura Jerárquica

Es la jerarquía a mas alto nivel, representa los distintos roles operativos.

| id_usuario | id_empresa | id_estructura | id        | id_jerarquía | Cargo                 | Nivel | Fecha creación | Fecha modificación |
| ---------- | ---------- | ------------- | --------- | ------------ | --------------------- | ----- | -------------- | ------------------ |
| us_001     | emp_001    | est_001       | cargo_001 |              | Gerente General       | 1     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_002 | cargo_001    | Director De Sección   | 2     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_003 | cargo_002    | Gerente de Area       | 3     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_004 | cargo_003    | Jefe de Departamentos | 4     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_005 | cargo_004    | Coordinador de area   | 5     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_006 | cargo_005    | Supervisor de area    | 6     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_007 | cargo_006    | Analista de area      | 7     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_008 | cargo_006    | Asistente de area     | 8     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_001       | cargo_009 | cargo_006    | Auxiliar de area      | 8     | 27/10/2024     | 27/10/2024         |

### Empresas - Organización

Es la estructura organizacional de mas alto nivel.

| id_usuario | id_empresa | id_estructura | id     | Descripción                           | Fecha creación | Fecha modificación |
| ---------- | ---------- | ------------- | ------ | ------------------------------------- | -------------- | ------------------ |
| us_001     | emp_001    | est_001       | org_1  | Dirección General                     | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_002       | org_2  | Dirección De Capital Humano           | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_002       | org_3  | Dirección De Mercadeo y Ventas        | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_002       | org_4  | Dirección Operativa                   | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_003       | org_5  | Gerencia de Transporte y distribución | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_004       | org_6  | Gerencia de Almacenes                 | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_004       | org_7  | Departamento de despacho              | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_004       | org_8  | Departamento de despacho              | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_003       | org_9  | Gerencia de Marca XX                  | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_003       | org_10 | Gerencia de Nominas y Compensaciones  | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | est_003       | org_11 | Gerencia de Reclutamiento y selección | 27/10/2024     | 27/10/2024         |

### Empresas - Jerárquica/Escalas

Compone la estructura jerárquica de las escalas y detalle de las posiciones.

| id_usuario | id_empresa | id_organización | id        | id_jerarquía | Cargo                         | Funciones                | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------------- | --------- | ------------ | ----------------------------- | ------------------------ | -------------- | ------------------ |
| us_001     | emp_001    | org_1           | cargo_001 |              | Gerente General               | Realiza muchas funciones | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | org_2           | cargo_002 | cargo_001    | Director De Capital Humano    | Realiza, x,x,            | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | org_2           | cargo_003 | cargo_002    | Director De Mercadeo y Ventas | Es responsable de        | 27/10/2024     | 27/10/2024         |

### Empresas - Jerárquica/Escalas-Perfil

Compone las características generales de la escala, acompaña el perfil de la posición.

| id_usuario | id_empresa | id_escala | Características | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------- | --------------- | -------------- | ------------------ |
| us_001     | emp_001    | cargo_001 | Proactivo       | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | cargo_001 | Positivo        | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | cargo_001 | Dinámico        | 27/10/2024     | 27/10/2024         |

### Empresas - Jerárquica/Escalas-Perfil-profesional

Compone las características generales de la escala, acompaña el perfil de la posición.

| id_usuario | id_empresa | id_escala | Características                           | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------- | ----------------------------------------- | -------------- | ------------------ |
| us_001     | emp_001    | cargo_001 | Ingeniero alimentos, Ingeniero Industrial | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | cargo_001 | Maestría gestión                          | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | cargo_001 | Diplomados en el area                     | 27/10/2024     | 27/10/2024         |

### Empresas - Jerárquica/Escalas-Compensaciones

Compone las compensaciones por escalas.

| id_usuario | id_empresa | id_escala | id_compensación | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------- | --------------- | -------------- | ------------------ |
| us_001     | emp_001    | cargo_001 | comp_001        | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | cargo_001 | comp_002        | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | cargo_001 | comp_003        | 27/10/2024     | 27/10/2024         |

### Empleados

Compone los peleados de las distintas empresas.

| id_usuario | id_empresa | id_empleado | Perfil                                | Fecha creación | Fecha modificación |
| ---------- | ---------- | ----------- | ------------------------------------- | -------------- | ------------------ |
| us_001     | emp_001    | empl_001    | Nombre Comercial, Ubicación,contactos | 27/10/2024     | 27/10/2024         |

### Empleados-Cargo

Compone los peleados de las distintas empresas.

| id_usuario | id_empresa | id_empleado | id_cargo  | fecha-inicio | fecha-final | Fecha creación | Fecha modificación |
| ---------- | ---------- | ----------- | --------- | ------------ | ----------- | -------------- | ------------------ |
| us_001     | emp_001    | empl_001    | cargo_001 | 27/10/2024   | 27/10/2024  | 27/10/2024     | 27/10/2024         |

### Contratación - Compensaciones

Compone todas las compensaciones.

| id_usuario | id_empresa | id_compensación | tipo   | Descripción           | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------------- | ------ | --------------------- | -------------- | ------------------ |
| us_001     | emp_001    | comp_001        | ley    | Salario Base          | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | comp_002        | ley    | Horas Extraordinarias | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | comp_003        | propia | Comisión por Cobros   | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | comp_004        | propia | Comisión por Ventas   | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | comp_005        | ley    | Salario Navidad       | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | comp_006        | ley    | Vacaciones            | 27/10/2024     | 27/10/2024         |

### Empleados-Compensaciones

Compone los peleados de las distintas empresas.

| id_usuario | id_empresa | id_empleado | id_compensación | monto     | fecha-inicio | fecha-final | Fecha creación | Fecha modificación |
| ---------- | ---------- | ----------- | --------------- | --------- | ------------ | ----------- | -------------- | ------------------ |
| us_001     | emp_001    | empl_001    | comp_001        | 25,000.00 | 27/10/2024   | 27/10/2024  | 27/10/2024     | 27/10/2024         |

### Nominas

Son las nominas de cada una de las empresas.

| id_usuario | id_empresa | id_nomina | Descripción                 | Periodo | fecha-inicio | fecha-final | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------- | --------------------------- | ------- | ------------ | ----------- | -------------- | ------------------ |
| us_001     | emp_001    | nom_001   | Nomina general de empleados | 15 Dias | 01/10/2024   | 15/10/2024  | 27/10/2024     | 27/10/2024         |

### Nominas-Variables

Acumula las variables necesarias para el calculo de la nomina.

| id_usuario | id_empresa | id_nomina | id_variable | Descripción               | Valor | Fecha creación | Fecha modificación |
| ---------- | ---------- | --------- | ----------- | ------------------------- | ----- | -------------- | ------------------ |
| us_001     | emp_001    | nom_001   | var_1       | Ingresos Ordinarios       | 235   | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Ingresos Extra-Ordinarios | 15    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Total Ingresos            | 250   | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Retención AFP             | 25    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Retención SFS             | 25    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Base ISR                  | 25    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Retención ISR             | 25    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Otros descuentos          | 25    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | nom_001   | var_1       | Salario Neto              | 25    | 27/10/2024     | 27/10/2024         |

### Tipos Variables

Acumula los tipos de variables (los algoritmos de calculo).

| id_usuario | tipo      | Descripción | Fecha creación | Fecha modificación |
| ---------- | --------- | ----------- | -------------- | ------------------ |
| us_001     | sumatoria | sumatoria   | 27/10/2024     | 27/10/2024         |
| us_001     | tasa      | tasa        | 27/10/2024     | 27/10/2024         |
| us_001     | escala    | escala      | 27/10/2024     | 27/10/2024         |

### Clasificación Variables

Calificación de las variables para agrupar calculo del calculo.

| id_usuario | clasificación | Descripción | Fecha creación | Fecha modificación |
| ---------- | ------------- | ----------- | -------------- | ------------------ |
| us_001     | ingreso       | sumatoria   | 27/10/2024     | 27/10/2024         |
| us_001     | retención     | tasa        | 27/10/2024     | 27/10/2024         |
| us_001     | deducción     | escala      | 27/10/2024     | 27/10/2024         |
| us_001     | gasto         | escala      | 27/10/2024     | 27/10/2024         |

### Variables de calculo

Acumula todas las variables reusable para el calculo de las nominas.

| id_usuario | id_empresa | id_variable | Descripción               | clasificación | tipo      | Fecha creación | Fecha modificación |
| ---------- | ---------- | ----------- | ------------------------- | ------------- | --------- | -------------- | ------------------ |
| us_001     | emp_001    | var_1       | Ingresos Ordinarios       | total         | sumatoria | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_2       | Ingresos Extra-Ordinarios | total         | sumatoria | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_3       | Total Ingresos            | total         | sumatoria | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_4       | Retención AFP             | retención     | escala    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_5       | Retención SFS             | retención     | escala    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_6       | Retención INFOTEP         | retención     | tasa      | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_7       | Gasto INFOTEP             | gasto         | tasa      | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_8       | Gasto AFP                 | gasto         | escala    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_9       | Gasto SFS                 | gasto         | escala    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_10      | Gasto SRL                 | gasto         | escala    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_11      | Base ISR                  | total         | sumatoria | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_12      | Retención ISR             | escala        | escala    | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_13      | Otros descuentos          | total         | sumatoria | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_14      | Salario Neto              | total         | sumatoria | 27/10/2024     | 27/10/2024         |

### Valores de calculo

Acumula todos los valores de calculo de las variables para escalas tasas.

| id_usuario | id_empresa | id_variable | fecha-inicio | fecha-final | escala    | tasa | Fecha creación | Fecha modificación |
| ---------- | ---------- | ----------- | ------------ | ----------- | --------- | ---- | -------------- | ------------------ |
| us_001     | emp_001    | var_12      | 01/01/2019   | 0           | 72,260.25 | 0.25 | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_12      | 27/10/2024   | 27/10/2024  | 52,027.42 | 0.20 | 27/10/2024     | 27/10/2024         |
| us_001     | emp_001    | var_12      | 27/10/2024   | 27/10/2024  | 34,685.00 | 0.15 | 27/10/2024     | 27/10/2024         |

## Escalas progresivas de gastos y retenciones

### Escala progresiva (ISR)

| escala    | tasa |
| --------- | ---- |
| 34,685.00 | 0.15 |
| 52,027.42 | 0.20 |
| 72,260.25 | 0.25 |

### Escala progresiva Retención. (SFS)

| escala     | tasa   |
| ---------- | ------ |
| 0.00       | 0.0304 |
| 200,000.00 | 0.0000 |

### Escala progresiva Gasto. (SFS)

| escala     | tasa   |
| ---------- | ------ |
| 0.00       | 0.0709 |
| 200,000.00 | 0.0000 |

### Escala progresiva Retención. (AFP)

| escala     | tasa   |
| ---------- | ------ |
| 200,000.00 | 0.0000 |
| 0.00       | 0.0287 |

### Escala progresiva Gasto. (AFP)

| escala     | tasa   |
| ---------- | ------ |
| 200,000.00 | 0.0000 |
| 0.00       | 0.071  |

### Escala progresiva Gasto. (SRL)

| escala    | tasa   |
| --------- | ------ |
| 77,410.00 | 0.0000 |
| 0.00      | 0.0125 |

### Tasa Gasto. (INFOTEP)

| escala | tasa |
| ------ | ---- |
| 0.00   | 0.01 |

### Tasa Retención. (INFOTEP)

| escala | tasa  |
| ------ | ----- |
| 0.00   | 0.005 |

## Calculo de días

### Vacaciones

| Meses | Dias  |
| ----- | ----- |
| 3.00  | 4.00  |
| 4.00  | 5.00  |
| 5.00  | 6.00  |
| 6.00  | 7.00  |
| 7.00  | 8.00  |
| 8.00  | 9.00  |
| 9.00  | 10.00 |
| 10.00 | 11.00 |
| 11.00 | 12.00 |
| 12.00 | 14.00 |
| 36.00 | 18.00 |

### Bonificación

| anos | días |
| ---- | ---- |
| 1.00 | 45   |
| 3.00 | 60   |

### pre-aviso

| meses | días |
| ----- | ---- |
| 3.00  | 7    |
| 6.00  | 14   |
| 12.00 | 28   |

### cesantía-meses

| meses | días |
| ----- | ---- |
| 3.00  | 6    |
| 6.00  | 13   |

### cesantía-años

| años | días |
| ---- | ---- |
| 1.00 | 21   |
| 5.00 | 23   |

Asistencia por incapacidad o muerte del trabajador.

### asistencia-meses

| meses | días |
| ----- | ---- |
| 6.00  | 10   |

### asistencia-años

| años | días |
| ---- | ---- |
| 1.00 | 15   |
