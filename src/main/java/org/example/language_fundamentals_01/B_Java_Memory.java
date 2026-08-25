package org.example.language_fundamentals_01;

public class B_Java_Memory {

    /*
# JVM Memory Management — Java 17 (Simple Explain Version)

## 1. Diagram — JVM Memory Layout

**In one line:**
Heap = objects & their contents
Stack = local vars & references (per thread).
Metaspace = class code & structure — not values
method >> calls live in Stack
---------------------------------------------------------------------------------
GC (Garbage Collector) is NOT a memory area ***
it's a process/component that runs inside the JVM.
It doesn't "live" in Heap;
instead, it acts on the Heap (and partly on Metaspace, to unload unused classes).

Think of it this way:
Heap = the room full of objects
GC = the cleaner who walks into that room and removes junk
The cleaner isn't part of the room — it's part of the building's maintenance system (JVM)
----------------------------------------------------------------------------------------------

┌─────────────────────────────────────────────────────────────────────────────┐
│                          JVM MEMORY (Java 17)                               │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────┐
│                         HEAP (Shared, GC-Managed)                           │
│                                                                             │
│   ┌───────────────────────────────────────────────────────────────────────┐ │
│   │                        YOUNG GENERATION                               │ │
│   │                                                                       │ │
│   │   ┌──────────┐      ┌────────────┐      ┌────────────┐                │ │
│   │   │  EDEN    │ ──▶  │ SURVIVOR 0 │ ──▶  │ SURVIVOR 1 │                │ │
│   │   │ New      │      │   (S0)     │      │   (S1)     │                │ │
│   │   │ Objects  │      │            │      │            │                │ │
│   │   └──────────┘      └────────────┘      └────────────┘                │ │
│   │        │                   │                   │                      │ │
│   │        └───────────────────┴───────────────────┘                      │ │
│   │                          Minor GC                                     │ │
│   └───────────────────────────────────────────────────────────────────────┘ │
│                                    │                                        │
│                                    │ Promoted after surviving GC cycles     │
│                                    ▼                                        │
│   ┌───────────────────────────────────────────────────────────────────────┐ │
│   │                      OLD GENERATION (Tenured)                         │ │
│   │                  Long-lived objects / Large objects                   │ │
│   │                  Cleaned by Major / Full GC                           │ │
│   └───────────────────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────────────────┘

┌──────────────────────┐  ┌────────────────────────────────────────────────┐
│       STACK          │  │               METASPACE                        │
│   (Per Thread)       │  │     (Native Memory - Off-Heap)                 │
│                      │  │                                                │
│  ┌────────────────┐  │  │  ┌────────────────────────────────────────┐    │
│  │   Stack Frame  │  │  │  │  • Class Metadata                      │    │
│  │   Method Call  │  │  │  │  • Method Bytecode                     │    │
│  │                │  │  │  │  • Runtime Constant Pool               │    │
│  │  • Local Vars  │  │  │  │  • Static Fields (class-level)         │    │
│  │  • References  │  │  │  │  • Reflection Data                     │    │
│  │  • Return Addr │  │  │  │  • JIT-optimized code metadata         │    │
│  └────────────────┘  │  │  └────────────────────────────────────────┘    │
│                      │  │                                                │
│  LIFO (Last-In-First-Out) │  Replaces PermGen (Java 8+)                  │
│  Auto-cleared on return   │  Auto-resizable (but can be limited)         │
└──────────────────────┘  └────────────────────────────────────────────────┘

┌──────────────────────┐  ┌────────────────────────────────────────────────┐
│    PC REGISTER       │  │          NATIVE METHOD STACK                   │
│   (Per Thread)       │  │            (Per Thread)                        │
│                      │  │                                                │
│  Points to next      │  │  Used for JNI / Native Methods                 │
│  bytecode instruction│  │  Calls C/C++ code via JNI                      │
│  to be executed      │  │  Managed by Native OS                          │
└──────────────────────┘  └────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────┐
│                         CODE CACHE (JIT Compiler)                           │
│  Stores compiled native code for hot methods                                │
│  Optimizes frequently executed code paths                                   │
│  Managed by JIT compiler (C1/C2 in HotSpot)                                 │
└─────────────────────────────────────────────────────────────────────────────┘

                          OBJECT LIFECYCLE FLOW

    ┌─────────────┐
    │ new Object()│
    └──────┬──────┘
           ▼
    ┌─────────────┐     ┌─────────────────┐
    │   EDEN      │────▶│   Minor GC      │
    │ (Young Gen) │     │   (Scavenge)    │
    └──────┬──────┘     └────────┬────────┘
           ▼                      ▼
    ┌─────────────┐     ┌─────────────────┐
    │ SURVIVOR S0 │◀────│ Age Counter     │
    │             │     │ Increment       │
    └──────┬──────┘     └─────────────────┘
           ▼
    ┌─────────────┐     ┌─────────────────┐
    │ SURVIVOR S1 │────▶│ Age Threshold   │
    │             │     │ Reached         │
    └──────┬──────┘     └─────────────────┘
           ▼
    ┌─────────────┐     ┌─────────────────┐
    │ OLD GEN     │────▶│ Major/Full GC   │
    │ (Tenured)   │     │ (More Expensive)│
    └─────────────┘     └─────────────────┘

---

## 2. The Main Areas — What & Why

**Heap**
- Stores: objects and arrays (anything made with `new`)***
- Shared by all threads
- Cleaned by: Garbage Collector (GC)
- Example: `Employee e = new Employee();` → the `Employee` object goes here

**Stack**
- Stores: method calls, local variables, references to heap objects
- One Stack per thread — not shared
- Works LIFO (last method called = first one finished)
- Cleared automatically when a method returns — no GC needed
- Example: inside `test()`, `int age = 25;` and the reference `e` sit here

**Metaspace**
- Stores: class structure — method bytecode, field names, constant pool
- Replaced the old "PermGen" from Java 8 onward
- Lives in native (off-heap) memory, grows automatically
- Note: the class *structure* is here, but static variable *values* actually sit on the Heap — good to mention if asked "where exactly?"

**Young Generation (part of Heap)**
- **Eden**: every new object is born here
- **Survivor (S0, S1)**: objects that survived one or more GC rounds
- Objects that survive enough rounds get promoted to Old Generation

**Old Generation (part of Heap)**
- Long-lived objects (e.g. caches, singletons, Spring beans)
- Cleaned less often, but cleaning it takes longer

===============================================================================================

## 3. Garbage Collection — How It Works

1. GC looks at **GC Roots** — active thread stacks, static fields, JNI references
2. Anything reachable from a GC Root = alive, keep it
3. Anything not reachable = garbage, remove it

**Two levels of cleaning:**
- **Minor GC** → cleans Young Generation only → fast, happens often
- **Major/Full GC** → cleans Old Generation (and can unload unused classes) → slower, happens less often

**Default GC in Java 17: G1GC**
- Splits the heap into regions
- Cleans the "most garbage-filled" regions first
- Good balance of speed and short pause times

Other GCs you can mention: Parallel GC (max throughput), Serial GC (simple, small apps), ZGC / Shenandoah (very short pauses, big heaps).

---

## 4. Common Errors — Simple Cause & Fix

| Error | Simple Cause | Simple Fix |
|---|---|---|
| `OutOfMemoryError: Java heap space` | Too many objects kept alive | Increase `-Xmx`, remove the leak |
| `OutOfMemoryError: Metaspace` | Too many classes loaded | Set `-XX:MaxMetaspaceSize` |
| `StackOverflowError` | Method calling itself with no stop condition | Add a base case to the recursion |
| Memory leak | Something (like a static list) keeps holding onto objects | Stop holding the reference, or use `WeakReference` |

**Example of a leak:**
```java
static List<Object> cache = new ArrayList<>();
void add() { cache.add(new Employee()); } // never removed → GC can't clean it
```

---

## 5. Useful Flags (for tuning)

```
-Xms512m        # starting heap size
-Xmx2g          # max heap size
-Xss512k        # stack size per thread
-XX:MaxMetaspaceSize=256m   # limit Metaspace
-XX:+UseG1GC    # choose GC type
```

**Tools to check memory:** `jstat`, `jmap`, `jconsole`, VisualVM, Java Flight Recorder

---

## 6. How to Explain It Out Loud (30 seconds)

> "JVM memory has two main parts — Heap and Stack. Heap holds all the objects and is shared by every thread; it's cleaned automatically by the Garbage Collector. Stack is per-thread and holds method calls and local variables — no GC needed there, it clears itself when a method finishes. The Heap itself is split into Young Generation, where new objects are born, and Old Generation, for objects that survive a long time. Class information — not objects, just the class structure — lives separately in Metaspace. Java 17 uses G1GC by default, which cleans the heap in regions to keep pauses short."

---

## 7. Fast Recall Table

| Term | Simple Meaning |
|---|---|
| Heap | Where objects live |
| Stack | Where method calls + local variables live (per thread) |
| Metaspace | Where class info lives |
| Eden | Where new objects are born |
| Survivor (S0/S1) | Waiting area before Old Gen |
| Old Generation | Long-living objects |
| Minor GC | Cleans Young Gen (fast) |
| Major/Full GC | Cleans Old Gen (slow) |
| G1GC | Default collector, region-based, short pauses |
| GC Roots | Starting points to check "is this object still needed?" |

=========================================================================================
## Memory Map — Grouped by Area

### 🟢 HEAP
| Element | Notes |
|---|---|
| Objects (`new Employee()`) | Every object created with `new` |
| Instance variables (non-static fields) | Stored inside the object |
| Arrays (`int[]`, `Employee[]`) | Arrays are objects in Java |
| Static variable **values** | Attached to the `Class` mirror object |
| String literals (`"abc"`) | Inside the String Pool (moved here since Java 7) |
| `new String("abc")` | Separate object, outside pool unless `.intern()` used |
| Wrapper caches (`Integer` -128 to 127) | Pre-created cached objects |
| Enum constants | Enums are classes → instances live here |
| Thread object itself | It's a regular object |

---

### 🔵 STACK (per thread)
| Element | Notes |
|---|---|
| Local variables (primitives) | `int age = 25;` |
| Local variables (object references) | The pointer only — object itself is on Heap |
| Method parameters | Treated like local variables |
| `this` reference | Points to current object on Heap |
| Return address / method frame | One frame per method call |
| `final` local variable | Same as normal local var, just immutable |

---

### 🟣 METASPACE
| Element | Notes |
|---|---|
| Class structure / bytecode | Loaded once per class |
| Static methods (code) | Just method code |
| Constant pool | Class-level constants, method/field references |
| `final static` compile-time constants | Compiler inlines the value at usage sites |
| Static variable **structure/slot** | The class-level "definition" — but the actual value sits on Heap |

---

### 🟠 PC REGISTER (per thread)
| Element | Notes |
|---|---|
| Next instruction address | Tracks where thread is executing |

---

### 🟡 NATIVE METHOD STACK (per thread)
| Element | Notes |
|---|---|
| Native method calls (JNI/C++) | Not regular Java code |


    * */
}
