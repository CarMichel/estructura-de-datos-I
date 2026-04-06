# Programa para calcular el factorial de un numero

def calcular_factorial(n):
    """
    Función que calcula el factorial de un numero n.
    El factorial se define como: n! = n * (n-1) * (n-2) ... * 1
    """
    if n < 0:
        return None  # El factorial no esta definido para números negativos
    elif n == 0 or n == 1:
        return 1
    else:
        resultado = 1
        for i in range(2, n + 1):
            resultado *= i
        return resultado

# Programa principal
try:
    
    numero = int(input("Introduce un numero para calcular su factorial: "))

    factorial = calcular_factorial(numero)

    if factorial is not None:
        print(f"El factorial de {numero} es: {factorial}")
    else:
        print("El factorial no esta definido para numeros negativos.")

except ValueError:
    print("Por favor, introduce un numero entero valido.")
