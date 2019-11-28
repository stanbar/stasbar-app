module.exports = {
  apps: [
    {
      name: "stasbar-gplay",
      interpreter: "/usr/bin/ts-node",
      script: "src/main.ts",
      exec_mode: "fork",
      autorestart: true,
      watch: false,
      max_memory_restart: "1G"
    }
  ]
};
