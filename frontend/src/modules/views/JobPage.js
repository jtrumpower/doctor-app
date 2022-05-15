import React, {useState} from 'react';
import {
  Box, Button,
  Checkbox,
  FormControlLabel, FormGroup,
  Radio, RadioGroup,
  Stack, TextField,
  Typography
} from "@mui/material";
import styled from "@emotion/styled";
import GenericTable from "../components/GenericTable";
import {JobApi} from "../api/JobApi";
import {JobTableModel} from "../components/model/JobTableModel";
import {useSnackbar} from "notistack";

const StyledBox = styled(Box)(({theme}) => ({
  marginTop: theme.spacing(1),
  paddingLeft: theme.spacing(1),
  paddingBottom: theme.spacing(1),
  border: "1px gray solid",
  borderRadius: "4px",
}));

const JobPage = () => {
  const [params, setParams] = useState({ type: 'DELTA', allRows: false, newFile: false, numRows: 1000 });
  const [jobs, setJobs] = useState([]);
  const {enqueueSnackbar} = useSnackbar();

  const handleChange = (e) => {
    const newVal = { ...params }
    console.log(e)
    if (e.target.type === 'checkbox') {
      newVal[e.target.name] = e.target.checked;
    } else {
      newVal[e.target.name] = e.target.value;
    }

    setParams(newVal);
  }

  const refreshJobs = () => {
    JobApi.getAllJobs().then(json => {
      setJobs(json)
    }).catch(error => {
      enqueueSnackbar(error, {variant: 'error'})
    });
  }

  const handleSubmit = (e) => {
    e.preventDefault();

    JobApi.postJob(params).then(json => {
      enqueueSnackbar("Submitted Job", {variant: 'success'});
    }).catch(error => {
      enqueueSnackbar(error, {variant: 'error'});
    });
  }

  React.useEffect(() => {
    refreshJobs();
  }, [])

  return (
      <Stack paddingTop={3}>
        <Typography variant="h5">
          New Job
        </Typography>
        <form onSubmit={handleSubmit}>
          <Stack spacing={1}>
            <StyledBox>
              <RadioGroup value={params.type}>
                <FormControlLabel value="DELTA" control={<Radio name="type" onChange={handleChange} /> } label="Delta data load" />
                <FormControlLabel value="FRESH" control={<Radio name="type" onChange={handleChange} /> } label="Fresh data load (truncate before loading)" />
              </RadioGroup>
            </StyledBox>
            <StyledBox>
              <FormGroup>
                <FormControlLabel control={<Checkbox name="newFile" checked={params.newFile} onChange={handleChange} /> } label="Retrieve new CSV" />
                <FormControlLabel control={<Checkbox name="allRows" checked={params.allRows} onChange={handleChange} /> } label="Import all rows (this take a long time)" />
                <TextField
                    type="number"
                    name="numRows"
                    label={"Number of Rows"}
                    disabled={params.allRows}
                    value={params.numRows}
                    sx={{ marginTop: 1, marginBottom: 1, maxWidth: 150 }}
                    onChange={handleChange} />
              </FormGroup>
            </StyledBox>
            <Button type="submit" variant="contained">Run Job</Button>
          </Stack>
        </form>
        <GenericTable
            title={JobTableModel.title}
            rows={jobs.map(job => JobTableModel.row(job))}
            header={JobTableModel.header()}
            onInterval={refreshJobs} />
      </Stack>
  )
}

export default JobPage;