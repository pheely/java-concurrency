# Controlling Phase Change in Concurrent-Phased Tasks

The `Phaser` class provides a method - `onAdvance()` that is executed each time it changes the phase. It returns `false`
if `Phaser` continues its execution or `true` if `Phaser` has finished and has to enter the termination state.

