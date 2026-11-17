# LoginMaterialYou - 2da Evaluación de Interfaces Móviles

Prototipo nativo de pantalla de inicio de sesión (**Login**) desarrollado desde cero en **Android Studio** con **Java** y **XML**, aplicando los estándares oficiales de diseño **Material Design 3 (M3)** y **Material You (Dynamic Color)**.

## Datos Académicos
- **Institución:** Tecnológico de Estudios Superiores del Oriente del Estado de México (TESOEM)
- **Autor:** David Farid Castañeda Baltazar (Matrícula: 226010004)
- **Carrera:** Ingeniería en Sistemas Computacionales (7mo Semestre)
- **Asignatura:** DMD-2302 – Diseño y Desarrollo de Interfaces Móviles
- **Docente:** Gustavo Moisés Romero González

## Características Implementadas
- **Material 3 y Material You:** Integración de `DynamicColors.applyToActivityIfAvailable(this)` en `MainActivity.java` para adaptar automáticamente la paleta tonal de la interfaz al tema y fondo de pantalla del sistema en dispositivos con Android 12+ (API 31+), con soporte completo para **Modo Claro** y **Modo Oscuro** (`Theme.Material3.DayNight.NoActionBar`).
- **Componentes Material nativos:** Uso de `MaterialCardView` elevada, campos de entrada `TextInputLayout` en variante `OutlinedBox` con esquinas redondeadas (`14dp`), alternancia nativa de visibilidad de contraseña (`password_toggle`), iconografía vectorial personalizada (`ic_email.xml`, `ic_lock.xml`), `MaterialCheckBox`, botones `MaterialButton` (Filled y Outlined) y `AssistChip` dinámico.
- **Validación de formulario:** Verificación en tiempo real de formato de correo electrónico (`Patterns.EMAIL_ADDRESS`) y longitud mínima de contraseña (`>= 6` caracteres) con retroalimentación contextual mediante `setError`, además de diálogo de confirmación `MaterialAlertDialogBuilder`.
- **Compatibilidad visual completa:** Manejo de márgenes del sistema (`EdgeToEdge` y `WindowInsetsCompat`) dentro de un contenedor desplazable (`ScrollView`) para evitar solapamientos con barras de estado y teclado virtual.
- **Pruebas físicas:** Compilado, desplegado vía depuración inalámbrica y validado directamente en dispositivo físico **Xiaomi Redmi Note 13 Pro (HyperOS / Android 16)** en ambos temas (Claro y Oscuro).

## Contenido del Repositorio
- Código fuente completo del proyecto en Android Studio (`MainActivity.java`, `activity_main.xml`, temas `themes.xml` / `themes.xml (night)` e íconos vectoriales en `res/drawable`).
- Archivos de configuración del proyecto (`build.gradle.kts`, `settings.gradle.kts`, `gradle.properties` y wrapper de Gradle).
- Documentación completa de la práctica (investigación y arquitectura, bocetos de baja fidelidad, esquemas estructurales/wireframes, maquetado visual de alta fidelidad y capturas de ejecución en dispositivo real).
