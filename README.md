# ERRORES Y EXCEPCIONES

## Tiempos

- Código listo más tardar el 15 (mañana)
- Diagrama de flujo / pseudocódigo y reporte del 16 al 17

## Requerimentos

La función `printf` debe tomar en cuenta lo siguiente:

### Texto a imprimir

- [ ] NO permitir Cadena vacía: `printf("")`

- [ ] Comillas

  - [ ] Están colocadas de inicio a fin del texto
  - [ ] No hay más de 2 comillas 

### Caracteres especiales

- [ ] Que no se permitan caracteres especiales como ñ, á, ¿

Encoding: ISO-8859-9, ISO-2022-CN

<!-- - [ ] NO permitir imprimir un %: `printf("%")`. Sólo permitirlo cuando viene acompañado de otro %:

<img src="./UnPorcentaje.png" width="300">

<img src="./DosPorcentajes.png" width="300"> -->

<!-- ### Caracteres especiales (secuencias de escape)

- [ ] Permitir únicamente las siguientes secuencias de escape (cualquier otra letra o símbolo seguido de un ' \\ ' marcar error):
    
    - \a
    - \b
    - \f
    - \n
    - \r
    - \t
    - \v
    - \\'
    - \\"
    - \\\
    - \\?

[Más información sobre las secuencias de escape](https://learn.microsoft.com/es-es/cpp/c-language/escape-sequences?view=msvc-170) -->

### Indicadores de formato de argumentos

- [x] Permitir únicamente los siguientes indicadores:

  - %c
  - %d
  - %i
  - %o
  - %u
  - %x
  - %e
  - %f
  - %g
  - %a
  - %n
  - %p
  - %s

[Más info](https://learn.microsoft.com/es-es/cpp/c-runtime-library/format-specification-syntax-printf-and-wprintf-functions?view=msvc-170)

### Validación de argumentos

- [ ] Verificar que el número de argumentos coincida con el número de indicadores de formato en la cadena de formato. O sea, si hay 2 `%d`, que haya dos argumentos: `printf("Primer numero: %d, Segundo numero: %d", argumento1, argumento2);`