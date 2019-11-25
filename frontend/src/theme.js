import {createMuiTheme} from "@material-ui/core";

const theme = createMuiTheme({
  palette: {
    type: "light",
    primary: {main: '#f7f7f7', light: "#ffffff", dark: "#c4c4c4"},
    secondary: {main: '#3dacd1', light: "#CEEBF6", dark: "#3dacd1"},
    text: {primary: "#5b6a72"},
  },
  typography: {
    useNextVariants: true,
  },
});

export default theme;
