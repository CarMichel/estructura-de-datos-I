# Juego del Ahorcado (HTML + JavaScript)

Este proyecto es una versión sencilla del clásico juego del ahorcado, implementado en **HTML** y **JavaScript**.  
La palabra clave utilizada es **"platano"**.

## 🚀 Cómo ejecutar el juego
1. Descarga el repositorio desde GitHub (`git clone` o descarga ZIP).
2. Asegúrate de que los archivos `ahorcado.html` y `ahorcado.js` estén en la misma carpeta.
3. Haz doble clic en `ahorcado.html` para abrirlo en tu navegador.
4. ¡Listo! El juego se ejecuta directamente porque está hecho con JavaScript puro.

## 🎮 Cómo jugar
1. El juego tiene 7 campos para ingresar letras de la palabra **platano**.
2. Presiona el botón **Verificar**:
- Si la letra es correcta, se muestra en el resultado.
- Si la letra es incorrecta, se borra del campo y se marca una parte del cuerpo con “X”.
3. Las partes del cuerpo se van llenando en este orden:
- Cabeza → Brazos → Cuerpo → Piernas → Pies
4. Si completas todas las partes con “X”, aparece un mensaje de **¡Perdiste!** y el juego se reinicia.
5. También puedes presionar el botón **Nuevo** en cualquier momento para limpiar los campos y empezar otra partida.

## 📌 Nota importante

Inicialmente se pensó en hacer el juego con **PHP**, pero se decidió usar **JavaScript** porque:
- PHP necesita un servidor (como **XAMPP**) para ejecutarse.
- Aún no se tiene experiencia instalando y configurando XAMPP.
- JavaScript es muy similar en lógica a PHP y permite ejecutar el juego directamente en el navegador sin servidor.

De esta forma, el juego es más fácil de probar y compartir desde GitHub.