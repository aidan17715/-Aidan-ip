# John User Guide

John is a friendly task management chatbot that helps you keep track of your todos, deadlines, and events. John uses a simple command-line interface that makes task management quick and easy.

## Features

### Adding a todo task: `todo`

Adds a simple todo task without any date or time.

**Format:** `todo DESCRIPTION`

- The `DESCRIPTION` is the task description.

**Example:** `todo read book`

```
____________________________________________________________
 Okay. I've added this task:
   [T][ ] read book
 Now you have 1 tasks in the list.
____________________________________________________________
```

---

### Adding a deadline task: `deadline`

Adds a task that needs to be completed by a specific date.

**Format:** `deadline DESCRIPTION /by DATE`

- The `DESCRIPTION` is the task description.
- The `DATE` must be in `yyyy-mm-dd` format (e.g., `2024-12-25`).

**Example:** `deadline return book /by 2024-12-25`

```
____________________________________________________________
 Okay. I've added this task:
   [D][ ] return book (by: Dec 25 2024)
 Now you have 2 tasks in the list.
____________________________________________________________
```

---

### Adding an event task: `event`

Adds a task that occurs during a specific time period.

**Format:** `event DESCRIPTION /from START_DATE /to END_DATE`

- The `DESCRIPTION` is the event description.
- The `START_DATE` and `END_DATE` must be in `yyyy-mm-dd` format.

**Example:** `event project meeting /from 2024-03-15 /to 2024-03-16`

```
____________________________________________________________
 Okay. I've added this task:
   [E][ ] project meeting (from: Mar 15 2024 to: Mar 16 2024)
 Now you have 3 tasks in the list.
____________________________________________________________
```

---

### Listing all tasks: `list`

Shows a list of all tasks in your task list.

**Format:** `list`

**Example:** `list`

```
____________________________________________________________
 Check this out. Here are the tasks in your list:
 1.[T][ ] read book
 2.[D][ ] return book (by: Dec 25 2024)
 3.[E][ ] project meeting (from: Mar 15 2024 to: Mar 16 2024)
____________________________________________________________
```

---

### Marking a task as done: `mark`

Marks a task as completed.

**Format:** `mark INDEX`

- The `INDEX` refers to the task number shown in the task list.
- The index must be a positive integer: 1, 2, 3, ...

**Example:** `mark 1`

```
____________________________________________________________
 Good. I've marked this task as done:
   [T][X] read book
____________________________________________________________
```

---

### Unmarking a task: `unmark`

Marks a previously completed task as not done.

**Format:** `unmark INDEX`

- The `INDEX` refers to the task number shown in the task list.
- The index must be a positive integer: 1, 2, 3, ...

**Example:** `unmark 1`

```
____________________________________________________________
 Okay. I've marked this task as not done yet:
   [T][ ] read book
____________________________________________________________
```

---

### Deleting a task: `delete`

Deletes a task from your task list permanently.

**Format:** `delete INDEX`

- The `INDEX` refers to the task number shown in the task list.
- The index must be a positive integer: 1, 2, 3, ...

**Example:** `delete 2`

```
____________________________________________________________
 Noted. I've removed this task:
   [D][ ] return book (by: Dec 25 2024)
 Now you have 2 tasks in the list.
____________________________________________________________
```

---

### Finding tasks: `find`

Finds all tasks that contain the specified keyword in their description.

**Format:** `find KEYWORD`

- The search is case-sensitive.
- Only the task description is searched.

**Example:** `find book`

```
____________________________________________________________
 Here are the matching tasks in your list:
 1.[T][ ] read book
 2.[T][ ] borrow book
____________________________________________________________
```

---

### Exiting the program: `bye`

Exits the John chatbot application.

**Format:** `bye`

**Example:** `bye`

```
____________________________________________________________
 Thank you so much.
____________________________________________________________
```

---

## Command Summary

| Action | Format | Example |
|--------|--------|---------|
| Add todo | `todo DESCRIPTION` | `todo read book` |
| Add deadline | `deadline DESCRIPTION /by DATE` | `deadline return book /by 2024-12-25` |
| Add event | `event DESCRIPTION /from START /to END` | `event meeting /from 2024-03-15 /to 2024-03-16` |
| List tasks | `list` | `list` |
| Mark task | `mark INDEX` | `mark 1` |
| Unmark task | `unmark INDEX` | `unmark 1` |
| Delete task | `delete INDEX` | `delete 2` |
| Find tasks | `find KEYWORD` | `find book` |
| Exit | `bye` | `bye` |

---

## Notes

- All tasks are automatically saved to a file (`./data/john.txt`) and will be loaded when you start John again.
- Date format must be `yyyy-mm-dd` (e.g., `2024-03-15`). Invalid dates will show an error message.
- Task indices start from 1, not 0.
- If you specify an invalid task number, John will show an error message.
