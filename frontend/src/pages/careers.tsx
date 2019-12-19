import {
  createStyles,
  Theme,
  withStyles,
  Typography,
  Container
} from "@material-ui/core";
import * as React from "react";
import "typeface-roboto";
import CareersJpg from "../assets/jpg/careers.jpg";

const styles = (theme: Theme) =>
  createStyles({
    root: {
      minHeight: "80vh",
      backgroundColor: theme.palette.primary.light,
      paddingBottom: "10vh"
    },
    title: {
      color: theme.palette.text.primary,
      paddingTop: theme.spacing(10),
      paddingBottom: theme.spacing(3),
      paddingLeft: theme.spacing(10),
      paddingRight: theme.spacing(10),
      fontSize: 80,
      fontWeight: 700,
      lineHeight: 1
    },
    slogan: {
      paddingLeft: theme.spacing(10),
      paddingRight: theme.spacing(10),
      fontSize: 20,
      lineHeight: 1
    },
    subtitle: {
      paddingTop: theme.spacing(3),
      fontSize: 50,
      lineHeight: "150%",
      fontWeight: 700
    },
    positionTitle: {
      color: theme.palette.secondary.main,
      marginTop: theme.spacing(3),
      fontWeight: 700,
      fontSize: "2rem",
      lineHeight: "150%"
    },
    positionPart: {
      color: theme.palette.text.secondary,
      fontWeight: 400,
      fontSize: "1rem",
      lineHeight: "150%"
    },
    positionPrice: {
      color: theme.palette.text.primary,
      fontWeight: 400,
      fontSize: "1rem",
      lineHeight: "150%"
    },
    image: {
      marginTop: theme.spacing(30),
      marginBottom: theme.spacing(20),
      maxWidth: "100%",
      maxHeight: "100%",
      width: "100%",
      height: "auto"
    }
  });

const Careers: React.FC = ({ classes }: { classes: any }) => (
  <div className={classes.root}>
    <Container maxWidth="lg">
      <Typography variant="h1" className={classes.title}>
        Careers
      </Typography>

      <Typography variant="subtitle1" className={classes.slogan}>
        At stasbar, we make the world a better place.
      </Typography>

      <img className={classes.image} src={CareersJpg} alt="Careers" />

      <Typography variant="h2" className={classes.subtitle}>
        Open positions
      </Typography>

      <div>
        <Typography variant="body1" className={classes.positionTitle}>
          Android Developer
        </Typography>

        <Typography variant="body2" className={classes.positionPart}>
          Intern
        </Typography>

        <Typography variant="body2" className={classes.positionPrice}>
          0 - 3000 PLN
        </Typography>
      </div>

      <div>
        <Typography variant="body1" className={classes.positionTitle}>
          Flutter Developer
        </Typography>

        <Typography variant="body2" className={classes.positionPart}>
          Intern
        </Typography>

        <Typography variant="body2" className={classes.positionPrice}>
          0 - 2000 PLN
        </Typography>
      </div>

      <div>
        <Typography variant="body1" className={classes.positionTitle}>
          Frontend Developer
        </Typography>

        <Typography variant="body2" className={classes.positionPart}>
          Intern
        </Typography>

        <Typography variant="body2" className={classes.positionPrice}>
          0 - 2000 PLN
        </Typography>
      </div>
    </Container>
  </div>
);

export default withStyles(styles)(Careers);
