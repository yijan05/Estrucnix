class cola:

    def __init__(self):
        self.cola = []
        self.size = 0

    def empty(self):
        return len(self.cola) == 0

    def push(self, dato):
        self.cola.append(dato)
        self.size += 1

    def pop(self):
        if self.empty():
            print("La cola está vacía")
        else:
            eliminado = self.cola.pop(0)
            self.size -= 1
            print(f"Dato eliminado: {eliminado}")

    def front(self):
        if self.empty():
            print("Cola vacía")
        else:
            print("Primer dato:", self.cola[0])

    def show(self):
        if self.empty():
            print("Cola vacía")
        else:
            print("Contenido de la cola:")
            for i in range(self.size - 1, -1, -1):
                print(f"[{i}] => {self.cola[i]}")


if __name__ == "__main__":
    opcion = 0
    cola = cola()

    while opcion != 6:
        print("\n--- Cola ---")
        print("1. Agregar dato")
        print("2. Eliminar")
        print("3. ¿Está vacía la cola?")
        print("4. Mostrar cola")
        print("5. Mostrar frente")
        print("6. Salir")

        try:
            opcion = int(input("Ingrese su opción: "))

            if opcion == 1:
                dato = input("Ingresa un dato: ")
                cola.push(dato)
            elif opcion == 2:
                cola.pop()
            elif opcion == 3:
                print("SÍ está vacía" if cola.empty() else "NO está vacía")
            elif opcion == 4:
                cola.show()
            elif opcion == 5:
                cola.front()
            elif opcion == 6:
                print("\n--- Sesión culminada ---")
            else:
                print("Opción inválida. Intenta de nuevo.")
        except ValueError:
            print("Entrada no válida. Debes ingresar un número.")


