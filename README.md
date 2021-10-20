## Usage

[Helm](https://helm.sh) must be installed to use the charts.  Please refer to
Helm's [documentation](https://helm.sh/docs) to get started.

Once Helm has been set up correctly, add the repo as follows:

    helm repo add lambda https://cyberdog52.github.io/facilitator-backend/

If you had already added this repo earlier, run `helm repo update` to retrieve
the latest versions of the packages.  You can then run `helm search repo
lambda` to see the charts.

To install the lambda-facilitator chart:

    helm install my-lambda-facilitator lambda/lambda-facilitator

To uninstall the chart:

    helm delete my-lambda-facilitator