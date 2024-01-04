from typing import TypeVar, List
from abc import ABC, abstractmethod

T = TypeVar('T')

class Person:
    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

class PersonComparator:
    @staticmethod
    def compare(person1: Person, person2: Person) -> int:
        return person1.age - person2.age

class TeacherService(ABC):
    @abstractmethod
    def get_all_teachers(self) -> List[T]:
        pass

class Teacher(Person):
    def __init__(self, name: str, age: int):
        super().__init__(name, age)

class TeacherServiceImpl(TeacherService):
    def __init__(self):
        self.teachers = []

    def get_all_teachers(self) -> List[Teacher]:
        return self.teachers

class AccountController:
    @staticmethod
    def averageAge(items: List[T]) -> float:
        total_age = sum(item.age for item in items)
        return total_age / len(items)

# Пример использования

teachers = TeacherServiceImpl()
teachers.teachers = [
    Teacher('John', 35),
    Teacher('Alice', 42),
    Teacher('Bob', 28)
]

sorted_teachers = sorted(teachers.get_all_teachers(), key=lambda x: x.age)
for teacher in sorted_teachers:
    print(teacher.name, teacher.age)

average_age = AccountController.averageAge(teachers.get_all_teachers())
print("Average Age:", average_age)
